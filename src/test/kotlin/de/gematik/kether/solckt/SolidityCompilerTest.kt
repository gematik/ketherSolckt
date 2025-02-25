/*
 * Copyright 2020 Web3 Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package de.gematik.kether.solckt

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.nio.file.Path
import java.nio.file.Paths

class SolidityCompilerTest {

    @ParameterizedTest
    @ValueSource(strings = ["Example.sol", "Flowfund.sol"])
    fun compilerCompilesSolidityFiles(solFileName: String, @TempDir tempDir: Path) {
        val solidityToCompile = this.javaClass.getResource("/$solFileName").readText()
        val solidityFile = Paths.get(tempDir.toAbsolutePath().toString(), solFileName).toFile()
        solidityFile.writeText(solidityToCompile)

        val compilerInstance = SolidityFile(solidityFile.absolutePath).getCompilerInstance()
        val result = compilerInstance.execute(
            SolcArguments.OUTPUT_DIR.param { tempDir.toAbsolutePath().toString() },
            SolcArguments.AST,
            SolcArguments.BIN,
            SolcArguments.OVERWRITE
        )
        assertEquals(0, result.exitCode)
        assertNotEquals(0, result.stdOut.length + result.stdErr.length)
        assertTrue(Paths.get(tempDir.toAbsolutePath().toString(), "${solFileName.dropLast(4)}.bin").toFile().exists())
        assertTrue(Paths.get(tempDir.toAbsolutePath().toString(), "$solFileName.ast").toFile().exists())
    }
}
