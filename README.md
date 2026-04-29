# Assignment 2 — KMP Algorithm

Implementation of the KMP algorithm from Figure 3.20 (page 138) of Compilers: Principles, Techniques, and Tools.  
This is a continuation of Assignment 1 — the failure function is reused here.

---

## Environment

This program was written in **Java** and can be run on any computer (Windows, Mac, or Linux).  
You just need to have Java installed, or you can run it online using OnlineGDB — no installation needed.

---

## How to Run

```bash
javac Main.java
java Main
```

Then pick an option:
- `1` → runs exercise a)
- `2` → runs exercise b)
- `3` → runs both
- `4` → enter your own text and check if the keyword is in it

---

## What the KMP Algorithm Does

KMP checks whether a **keyword** appears inside a **text string**.

The naive way would be to check every position in the text one by one, which is slow.  
KMP is smarter: when a mismatch happens, it uses the **failure function** (from Assignment 1) to skip ahead instead of starting over. This makes it run in **O(m + n)** time, where `m` is the text length and `n` is the keyword length.

---

## Exercise 3.4.6 Results

Keyword: `ababaa`

| | Text | Result |
|-|------|--------|
| a) | `abababaab` | **yes** — `ababaa` is found inside the text |
| b) | `abababbaa` | **no**  — `ababaa` is not found inside the text |
