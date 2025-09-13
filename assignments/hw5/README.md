# Homework 5: Encryption/Decryption System

## Overview
This assignment implements a comprehensive encryption and decryption system using the Vigenère cipher algorithm. The system processes text through preprocessing, encryption, and decryption phases using Map data structures and key-based encryption techniques.

## Features
- **Text Preprocessing**: Clean and prepare input text for encryption
- **Vigenère Cipher**: Implementation of classical polyalphabetic substitution cipher
- **Encryption**: Convert plaintext to ciphertext using a keyword
- **Decryption**: Reverse the encryption process to recover original text
- **Alphabet Management**: Handle English alphabet with Map-based lookup tables
- **Key Stream Generation**: Repeat encryption key to match text length

## Class Structure
- `alphabet.java` - Manages English alphabet and creates encryption/decryption lookup tables
- `preprocessor.java` - Cleans and prepares text for processing
- `encryptor.java` - Handles encryption of plaintext using Vigenère cipher
- `decryptor.java` - Handles decryption of ciphertext back to plaintext
- `tester.java` - Test harness for validating encryption/decryption operations

## Key Components

### Alphabet Management
- Creates nested Map structure for character transformations
- Maps each alphabet character to all possible cipher transformations
- Uses LinkedHashSet to maintain alphabetical order

### Preprocessing
- Removes non-alphabetic characters
- Converts text to uppercase
- Prepares clean input for encryption algorithms

### Encryption Process
1. Generate keystream by repeating the key
2. Use nested Maps to find corresponding cipher characters
3. Transform each plaintext character using the keystream

### Decryption Process
1. Generate same keystream used for encryption
2. Reverse lookup in the nested Maps
3. Recover original plaintext characters

## Data Structures Used
- **LinkedHashSet**: Maintains ordered English alphabet
- **HashMap**: Nested structure for character transformations
- **String**: Text manipulation and keystream generation

## How to Run
1. Compile all Java files: `make compile` or `javac *.java`
2. Run the tester: `make test` or `java tester`
3. The system will demonstrate encryption and decryption operations

## Vigenère Cipher Algorithm
The Vigenère cipher uses a keyword to encrypt text:
- Each letter in the plaintext is shifted by the corresponding letter in the key
- The key is repeated to match the length of the plaintext
- Example: HELLO + KEY → RIJVS (with proper Vigenère transformation)

## Example Usage
```
Original Text: "HELLO WORLD"
Preprocessed: "HELLOWORLD"
Key: "SECRET"
Keystream: "SECRETSECR"
Encrypted: "ZINCZTKZRX"
Decrypted: "HELLOWORLD"
```

## Learning Objectives
- Understanding classical cryptography algorithms
- Working with nested Map data structures
- String manipulation and processing
- Key-based encryption techniques
- Algorithm implementation and testing
- Data structure selection for specific use cases

## Security Note
The Vigenère cipher is a historical encryption method and should not be used for actual security purposes in modern applications. This implementation is for educational purposes only.

## Time Complexity
- Preprocessing: O(n) where n is text length
- Keystream Generation: O(n) where n is text length
- Encryption/Decryption: O(n) where n is text length
- Map Initialization: O(26²) = O(1) for English alphabet

## Files
- Source code files (*.java)
- Makefile for compilation and testing
- Student submission archive (contains personal information)