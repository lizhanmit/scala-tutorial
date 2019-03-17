# Scala Tutorial

- `object` declaration is commonly known as a singleton object.
- Static members (methods or fields) do not exist in Scala. Rather than defining static members, the Scala programmer declares these members in singleton objects.

### Types

- `Any` is a super-type of all other types in Scala.
- The type `Unit` refers to nothing meaningful, which is similarly to `void` in Java.
  - **All functions must return something.** If you do not want to return, return `Unit`. 
  - One instance of `Unit` can be declared literally like `()`.
- `Null` is provided mostly for interoperability with other JVM languages and should almost **never** be used in Scala code. 

---

### Default Values

- 0 for numeric types
- false for the Boolean type
- () for the Unit type 
- null for all object types

For generic type, assign it as `_`.

---

### Case Classes

Differ from standard classes in the following ways: 

 - do not need to write `new` when creating the instance.
 - do not need to write getter method in class. You can get through `.` directly. 
 - `equals`, `hashCode` and `toString` methods are provided.
 - instances of these classes can be decomposed through pattern matching. 
 - compared by value.
 
```scala
val point = Point(1, 2)
val anotherPoint = Point(1, 2)
val yetAnotherPoint = Point(2, 2)

if (point == anotherPoint) {
  println(point + " and " + anotherPoint + " are the same.")
} else {
  println(point + " and " + anotherPoint + " are different.")
} // Point(1,2) and Point(1,2) are the same.

if (point == yetAnotherPoint) {
  println(point + " and " + yetAnotherPoint + " are the same.")
} else {
  println(point + " and " + yetAnotherPoint + " are different.")
} // Point(1,2) and Point(2,2) are different.
```

---

### Variables

In functional programming language, it is encouraged to use immutable constants whenever possible. In Scala, use `val` as possible as you can rather that `var`.

---

### Traits

When a trait extends an abstract class, it does not need to implement the abstract members.

---

### Console Input & Output

Need `import io.StdIn._` before using it.

- `readInt`
- `readDouble`
- `readByte`
- `readShort`
- `readFloat`
- `readLong`
- `readChar`
- `readBoolean`
- `readLine`: can have a parameter as prompt.
