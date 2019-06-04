# ![JmeConverter](icon-64.png) JmeConverter
A utility to convert JME3-compatible models to the jMonkeyEngine binary j3o format.

[![Build Status](https://travis-ci.com/randomstack/JmeConverter.svg?branch=master)](https://travis-ci.com/randomstack/JmeConverter)

## Documentation
General documentation can be found on the [wiki.](https://github.com/randomstack/JmeConverter/wiki)
The javadoc can be found at the [gh-pages.](https://randomstack.github.io/JmeConverter/javadoc/org/randomstack/jmeconverter/Converter.html)

## Installation
The library is available on [bintray](https://dl.bintray.com/randomstack/RandomStack) and can be included in your build tool.

Gradle snippet:
```gradle
compile 'org.randomstack:jmeconverter:0.1.0'
```

Maven snippet:
```xml
<dependency>
  <groupId>org.randomstack</groupId>
  <artifactId>jmeconverter</artifactId>
  <version>0.1.0</version>
</dependency>
```

The repository should be added to your build file. Instructions can be found [here.](https://bintray.com/randomstack/RandomStack/JmeConverter)

## Building
This library uses [gradle](https://gradle.org) as build system, and comes with the gradle wrapper included. So no prior installation on your computer is required!
You can just use the `gradlew` or `gradlew.bat` executables in the root of the sources.

To run a full build, use:
```bash
$ ./gradlew build
```

To get an overview of all gradle tasks use:
```bash
$ ./gradlew tasks
```

## Contributing
If you have a bug or an idea, browse the open [issues](https://github.com/randomstack/JmeConverter/issues) before opening a new one.

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## License
This project is licensed under the BSD 3-Clause License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgements
- Icon made by Freepik from www.flaticon.com