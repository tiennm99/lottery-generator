# lottery-generator

A lottery number generator written in Go that generates random sequences and tracks when any sequence appears multiple times.

## Features

- Generates random sequences of 6 numbers from 1-45
- Tracks sequence frequency using a map
- Stops when any sequence appears 6 times
- Prints the generation count and matching sequence

## Usage

```bash
go run main.go
```

## Example Output

```
1831593
[37 6 43 5 11 31]
Done
```

## Why "stop at 6 appearances"

This is a statistical curiosity inspired by [Vietlott](https://vietlott.vn/) Power 6/45 — Vietnam's national lottery where players pick 6 numbers from 1–45. The question: *how many draws would it take before any exact 6-number combination repeats?*

By the birthday paradox, with C(45,6) = 8,145,060 possible combinations, you'd expect a repeat after roughly √(2 × 8,145,060 × ln 2) ≈ **3,360 draws** on average. This program runs the simulation and stops as soon as one sequence has been generated exactly 6 times — letting you observe the actual count empirically.

## Earlier versions

This repository keeps the full history of the earlier implementations. The first
version was written in Java (2023), then rewritten in Python, and in 2025 in Go.
Browse them at the last commit of each:

- [Java version](https://github.com/tiennm99/lottery-generator/tree/98c8ad5a6b49bda9ec342a95408fb10676640d22)
- [Python version](https://github.com/tiennm99/lottery-generator/tree/f7432edaf382954e1dacfc4833b3120a64546163)
