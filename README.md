# kether-solckt

based on https://github.com/web3j/web3j-sokt

Example usage:

```kotlin
val fileName = filePath.substringAfterLast("/")
println("sokt Processing $fileName")
val solidityFile = SolidityFile(filePath)

println("Resolving compiler version for $fileName")
val compilerInstance = solidityFile.getCompilerInstance()

println("Resolved ${compilerInstance.solcRelease.version} for $fileName")

val result = compilerInstance.execute(
    SolcArguments.OUTPUT_DIR.param { "/tmp" },
    SolcArguments.BIN,
    SolcArguments.OVERWRITE
)

println("Solc exited with code: ${result.exitCode}")
println("Solc standard output:\n${result.stdOut}")
println("Solc standard error:\n${result.stdErr}")

```

## License

Copyright 2020 Web3 Labs Ltd.
Copyright 2023-2024 gematik GmbH

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.

See the [LICENSE](./LICENSE.txt) for the specific language governing permissions and limitations under the License.

Unless required by applicable law the software is provided "as is" without warranty of any kind, either express or implied, including, but not limited to, the warranties of fitness for a particular purpose, merchantability, and/or non-infringement. The authors or copyright holders shall not be liable in any manner whatsoever for any damages or other claims arising from, out of or in connection with the software or the use or other dealings with the software, whether in an action of contract, tort, or otherwise.

The software is the result of research and development activities, therefore not necessarily quality assured and without the character of a liable product. For this reason, gematik does not provide any support or other user assistance (unless otherwise stated in individual cases and without justification of a legal obligation). Furthermore, there is no claim to further development and adaptation of the results to a more current state of the art.

Gematik may remove published results temporarily or permanently from the place of publication at any time without prior notice or justification.