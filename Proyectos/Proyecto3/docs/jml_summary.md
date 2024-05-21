Made by: Esteban Leiva M
# OpenJML summary
> Command to execute: 
>`./openjml ~/Repositories/Seguridad_Del_Softare_2024/Proyectos/Proyecto3/src\ /StringUtils.java`
### Sintax
```java
public class Z{
    /*@  <-- must be the first character */
   //@ without blank space before
   void m(){...}
}

```
|   Anotation   |     Example     |  
|---------|---------|
|Modifiers| pure|
| CLauses| ensures|
| Types| \real|
| Expressions tokens| \result|

### postconditions
* Are the return conditions
* `//@ ensures`
* ` \result` keyword may only be used in ensures clauses of method specifications
### preconditions
* Are the expected arguments
* `//@ requires`
* `//@ requires a != null`
* `//@ requires 0<= i < a.length`

###### **There may be an order to the requires clauses**
```java
public class T_requires3 {

  //@ requires 0 <= index < a.length;
  //@ requires a != null;
  //@ ensures \result == a[index];
  public int getElement(int[] a, int index) {
    return a[index];
  }
}
```
produces
```
T_requires3.java:4: verify: The prover cannot establish an assertion (UndefinedNullDeReference) in method getElement
  //@ requires 0 <= index < a.length;
                             ^
1 verification failure

```
### Assert
* Is a condition that is expected to point whithin a funtion
* This condition works in the line of code that you wanna evaluate

### Loops

### asumes
* used to temporarily summarize the effect of preceding code.

### JML expressions
JML expressions are not allowed to have side-effects. So the ++, --, and op= (e.g., +=) operators are not allowed in JML expressions.

Note that the non-short-circuiting boolean operators & and | are legal in both Java and JML, though the short-circuiting versions && and || are much more commonly used in Java because they can be more efficient. In static reasoning, however, execution efficiency does not matter. In static reasoning, & and | are simpler to reason about, but && and || are often needed because of well-definedness considerations.