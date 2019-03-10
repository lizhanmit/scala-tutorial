# Scala Tutorial

- `object` declaration is commonly known as a singleton object.
- Static members (methods or fields) do not exist in Scala. Rather than defining static members, the Scala programmer declares these members in singleton objects.
- `Any` is a super-type of all other types in Scala.

### Default Values

- 0 for numeric types
- false for the Boolean type
- () for the Unit type 
- null for all object types

For generic type, assign it as `_`.

### Case Classes

Differ from standard classes in the following ways: 

 - do not need to write `new` when creating the instance.
 - do not need to write getter method in class. You can get through `.` directly. 
 - `equals`, `hashCode` and `toString` methods are provided.
 - instances of these classes can be decomposed through pattern matching. 
 
### Variables

In functional programming language, it is encouraged to use immutable constants whenever possible. In Scala, use `val` as possible as you can rather that `var`.

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
