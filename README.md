# Japanese Text Converter

A Java-based tool for bidirectional conversion between Romaji, Hiragana, Katakana, and English-to-Katakana transliteration. Designed for language learners, developers, and enthusiasts working with Japanese text processing.

## Features

### 1. Romaji to Hiragana

Converts Romaji (Latin script) input into Hiragana, the native Japanese syllabary.  

- Handles small tsu (っ) for double consonants (e.g., "kitten" → きってん).  
- Supports syllables like "sha", "chu", "kyo".  

**Example**:  
Input: `konnichiwa sekai`  
Output: `こんにちはせかい`

---

### 2. Romaji to Katakana

Converts Romaji input into Katakana, used for foreign words and loanwords.  

- Handles prolonged sound marks (ー) for vowels (e.g., "kōhī" → コーヒー).  
- Supports modern syllables like "fa", "ti", "she".  

**Example**:  
Input: `arigatou`  
Output: `アリガトウ`

---

### 3. Hiragana to Romaji

Converts Hiragana text back into Romaji for pronunciation or input methods.  

- Handles combined characters (e.g., きゃ → "kya").  
- Supports reverse mapping of small tsu (っ) to double consonants.  

**Example**:  
Input: `ありがとう`  
Output: `arigatou`

---

### 4. Katakana to Romaji

Converts Katakana text into Romaji, ideal for transliterating loanwords.  

- Handles prolonged sound marks (ー) as hyphens or extended vowels.  
- Supports modern Katakana combinations (e.g., ウィ → "wi").  

**Example**:  
Input: `サンキュー`  
Output: `sankyuu`

---

### 5. English to Katakana

Transliterates English words into Katakana using phonetic approximations.  

- Uses a dictionary (`kafile.txt`) for common loanwords (e.g., "coffee" → コーヒー).  
- Falls back to CMU phonetic notation and IPA conversion for unknown words.  

**Example**:  
Input: `hello world`  
Output: `ハロー・ワールド`

