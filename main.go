package main

import (
	"fmt"
	"math/rand"
	"sort"
	"time"
)

func main() {
	n := 45
	seqLength := 6
	matchTimes := 6
	maxGeneration := 1000000000000

	rand.Seed(time.Now().UnixNano())

	sequenceCount := make(map[string]int)
	count := 0

	for count < maxGeneration {
		sequence := generateRandomSequence(n, seqLength)
		seqKey := sequenceToString(sequence)
		sequenceCount[seqKey]++

		if sequenceCount[seqKey] == matchTimes {
			fmt.Println(count)
			fmt.Println(sequence)
			break
		}
		count++
	}

	fmt.Println("Done")
}

func generateRandomSequence(n, seqLength int) []int {
	numbers := make([]int, n)
	for i := 0; i < n; i++ {
		numbers[i] = i + 1
	}

	rand.Shuffle(len(numbers), func(i, j int) {
		numbers[i], numbers[j] = numbers[j], numbers[i]
	})

	return numbers[:seqLength]
}

func sequenceToString(sequence []int) string {
	sorted := make([]int, len(sequence))
	copy(sorted, sequence)
	sort.Ints(sorted)

	result := ""
	for i, num := range sorted {
		if i > 0 {
			result += ","
		}
		result += fmt.Sprintf("%d", num)
	}
	return result
}