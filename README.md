# Hash Table with Chaining

This is a Java project I made for my Data Structures and Algorithms class. It's a hash table that uses chaining to handle conflicts, with each chain implemented as a linked list.

## Hash Function

For my hash function, I used the multiplication method, as it's fairly simple to understand and explain.

```
/**
 * hashing function implementing multiplication method of hashing
 * 0x7fffffff is a mask bit, it works as converter to absolute value
 */
private int hash(K key) {
    return ((int) ((1247463646*key.hashCode() & 0x7fffffff) % Math.pow(2, 32)) >> 16) % size;
}
```

## Code Readability

I put effort into making my code readable and understandable. I also presented the code and the concept of hash tables and chaining in my Data Structures and Algorithms class.

## Usage

To use this hash table, clone the repo and compile and run the `HashTableChaining.java` file. You can add, remove, and search for items in the table.
