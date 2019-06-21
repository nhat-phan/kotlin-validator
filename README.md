# Kotlin Validator
[![Travis](https://jitpack.io/v/nhat-phan/kotlin-validator.svg?style=flat-square)](https://jitpack.io/#nhat-phan/kotlin-validator/0.4.3)

A kotlin multi-platform library for validating data. 

Highlighted features:

* Fluent syntax with type safe Kotlin-DSL
* Support nested structure, array-item validation
* Extendable rules (custom rule)
* Custom message

## Install

Currently an artifact is available in JitPack only.

Using with gradle projects:

```groovy

// Step 1. Add the JitPack repository to your build file
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}

// Step 2. Add the dependency
dependencies {
    implementation 'com.github.nhat-phan.kotlin-validator:kotlin-validator:0.4.3'
}

```

## Usage

### Quick example

First of all, this is a class you want to validate

```kotlin
data class User(username: String, email: String, age: Int)
```

Let's create a Validator for class User 

```kotlin
import net.ntworld.kotlin.validator.validator

val validator = validator<User> {
    User::username always required
    User::email always required
}
```

Use the validator to validate User's instance

```kotlin
validator.validate(User("", "", 0)) // -> Invalid
validator.validate(User("valid", "valid", 0)) // -> Valid
```

### Builtin rules
TBD

#### Builtin rule for String
TBD

##### `notEmpty`
TBD

##### `minLength()`
TBD

##### `maxLength()`
TBD

##### `exactLength()`
TBD

#### Builtin rule for Array
TBD

### Write your custom rule

It's very easy to write your custom rule, there are 2 steps

Step 1. Write a class which implements Rule interface:

```kotlin
import net.ntworld.kotlin.validator.Rule

class YourRule: Rule<String> {
    override val message: String = ":attribute must be match your requirement" 

    override fun passes(attribute: String, value: String?): Boolean {
        // Write your validation logic in here
        return value === "dummy"
    }
}
```

Step 2. Choose your rule name and add it into ValidatorRules via extension

```kotlin

import net.ntworld.kotlin.validator.ValidatorRules

val ValidatorRules.yourRuleName: Rule<String>
    get() = YourRule()

// Please note that you can use Singleton instead of always creating new YourRule instance 
```

After these steps your can enjoy your custom rule:

```kotlin
val validator = validator<User> {
    User::username always required and yourRuleName
}


validator.validate(User("ok", "", 0)) // -> Invalid
validator.validate(User("dummy", "", 0)) // -> Valid
```

### Extend/Combine Validators

Validator can be extend/combine together just like inheritance/composition of classes.

#### Extend validator

You can use keywords `extend` to extend as many validator as you want.

```kotlin
val usernameValidator = validator<User> {
    User::username always required
}

val emailValidator = validator<User> {
    User::email always required
}

val validator = validator<User> {
    extend(usernameValidator)
    extend(emailValidator)
    
    User::age always required and gt(0)
}


validator.validate(User("", "", 10)) // -> Invalid
validator.validate(User("valid", "valid", 10)) // -> Valid
```

#### Combine validator

If you don't want to extend you can combine validators together via `+` operator

```kotlin
val usernameValidator = validator<User> {
    User::username always required
}

val emailValidator = validator<User> {
    User::email always required
}

val ageValidator = validator<User> {
    User::age always required and gt(0)
}

val validator = usernameValidator + emailValidator + ageValidator

validator.validate(User("", "", 10)) // -> Invalid
validator.validate(User("valid", "valid", 10)) // -> Valid
```

## Contribute

PRs are welcomed to this project, and help is needed in order to keep up with the changes of Laravel Eloquent. 
If you want to improve the library, add functionality or improve the docs please feel free to submit a PR.

## License

MIT © Nhat Phan
