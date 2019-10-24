# Gradle Lint Plugin

![Support Status](https://img.shields.io/badge/nebula-supported-brightgreen.svg)
[![Build Status](https://travis-ci.org/nebula-plugins/gradle-lint-plugin.svg?branch=master)](https://travis-ci.org/nebula-plugins/gradle-lint-plugin)
[![Coverage Status](https://coveralls.io/repos/github/nebula-plugins/gradle-lint-plugin/badge.svg?branch=master)](https://coveralls.io/github/nebula-plugins/gradle-lint-plugin?branch=master)
[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/nebula-plugins/gradle-lint-plugin?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)
[![Apache 2.0](https://img.shields.io/github/license/nebula-plugins/gradle-lint-plugin.svg)](http://www.apache.org/licenses/LICENSE-2.0)

## Purpose

The Gradle Lint plugin is a pluggable and configurable linter tool for identifying and reporting on patterns of misuse or deprecations in Gradle scripts and related files.  It is inspired by the excellent ESLint tool for Javascript and by the formatting in NPM's [eslint-friendly-formatter](https://www.npmjs.com/package/eslint-friendly-formatter) package.

It assists a centralized build tools team in gently introducing and maintaining a standard build script style across their organization.

## Getting Started

Read the [full documentation](https://github.com/nebula-plugins/gradle-lint-plugin/wiki). 

To apply this plugin:

```groovy
buildscript { repositories { jcenter() } }
plugins {
  id 'nebula.lint' version '15.0.0'
}
```
    
*Important:* For now, in a multi-module build you **must** apply lint to the root project, at a minimum.

Alternatively:

```groovy
buildscript {
  repositories { jcenter() }
  dependencies {
    classpath 'com.netflix.nebula:gradle-lint-plugin:latest.release'
  }
}


apply plugin: 'nebula.lint'
```

Define which rules you would like to lint against:

```groovy
gradleLint.rules = ['all-dependency'] // add as many rules here as you'd like
```

For an enterprise build, we recommend defining the lint rules in a `init.gradle` script or in a gradle script that is included via the Gradle `apply from` mechanism.

For multimodule projects, we recommend applying the plugin in an allprojects block:

```groovy
allprojects {
  apply plugin: 'nebula.lint'
  gradleLint.rules = ['all-dependency'] // add as many rules here as you'd like
}
```
## api/implementation support 

[#257](
https://github.com/nebula-plugins/gradle-lint-plugin/pull/257)  introduced api/implementation configuration support.

This allows to show warnings around api/implementation configurations

Since we need to do some major work to keep track of declared configurations and then replace code with the proper configuration, we decided to just show warnings for now.

This work includes finding dependency information for non resolvable configurations so we look into the parents

If [gradle/gradle#11106](https://github.com/gradle/gradle/issues/11106) lands some day, we could definitely enhance this experience.

While it is great to have automatic fix, not having it is worse. So for now warning about this with the same detail as before is much better than a broken experience with new gradle configurations

## Warning
Gradle Lint Plugin currently doesn't support:

* kotlin build scripts. Please, switch to groovy build script if you want to use linting. [#166](https://github.com/nebula-plugins/gradle-lint-plugin/issues/166)


## License

Copyright 2015-2018-2019 Netflix, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

<http://www.apache.org/licenses/LICENSE-2.0>

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

