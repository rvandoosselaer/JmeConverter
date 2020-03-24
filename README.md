# ![JmeConverter](icon-64.png) JmeConverter
A utility to convert JME3-compatible models to the jMonkeyEngine binary j3o format.

[![Build Status](https://travis-ci.com/rvandoosselaer/JmeConverter.svg?branch=master)](https://travis-ci.com/rvandoosselaer/JmeConverter) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/9266e68729a447e2b8b0630468e914be)](https://www.codacy.com/manual/rvandoosselaer/JmeConverter?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=rvandoosselaer/JmeConverter&amp;utm_campaign=Badge_Grade)

## Documentation
General documentation can be found on the [wiki.](https://github.com/rvandoosselaer/JmeConverter/wiki)
The javadoc can be found at the [gh-pages.](https://rvandoosselaer.github.io/JmeConverter/1.0.0/javadoc/)

## CLI tool usage
Download the latest release from the [releases](https://github.com/rvandoosselaer/JmeConverter/releases) page and unpack the archive.

Inside the bin folder, you can find the `jmeconverter` and `jmeconverter.bat` executables.

Run the executable with a model path parameter.

```bash
$ jmeconverter.bat C:\Downloads\MyModel\model.blend
```

The above command will convert the `C:\Downloads\MyModel\model.blend` file to `C:\Downloads\MyModel\model.j3o`.

## Using the library

The library is available on [bintray](https://bintray.com/remyvd/rvandoosselaer/jmeconverter) and can be included in your build tool.

**Step 1.** Add the repository `https://dl.bintray.com/remyvd/rvandoosselaer` to the list of repositories.

**Step 2.** Add the dependency information:

group: com.rvandoosselaer
artifact: jmeconverter
version: 1.0.0

Check the [releases](https://github.com/rvandoosselaer/JmeConverter/releases) or [bintray](https://bintray.com/remyvd/rvandoosselaer/jmeconverter) pages for available versions.

**Step 3.** That's it!

Gradle example:

```groovy
repositories {
    maven {
        url  'https://dl.bintray.com/remyvd/rvandoosselaer' 
    }
}

dependencies {
    compile 'com.rvandoosselaer:jmeconverter:1.0.0'
}
``` 

## Contributing
If you have a bug or an idea, you can create a ticket for it [here](https://github.com/rvandoosselaer/JmeConverter/issues).

## License
This project is licensed under the BSD 3-Clause License - see the [LICENSE](LICENSE) file for details

## Acknowledgements
-   Icon made by [Freepik](https://www.freepik.com/home) from www.flaticon.com
