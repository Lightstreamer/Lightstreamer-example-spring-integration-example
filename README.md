# Build and deploy

To build the Adapter Set sample, execute:

```sh
$ ./gradlew deploy
```

Then copy the generated `build/spring-example` folder to `<LIGHTSTREAMER_HOME>/adapters`:

```
$ cp -r build/spring-example <LIGHTSTREAMER_HOME>/adapters/
```

Launch the Lightstreamer server
