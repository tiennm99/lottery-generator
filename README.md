# go-lottery-generator

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

## Original Python Version

*In 2025, I rewrote this project using Go. The original Python version of this project can be found at [feature/python](https://github.com/tiennm99/lottery-generator/tree/feature/python) branch.*
