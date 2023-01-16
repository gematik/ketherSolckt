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