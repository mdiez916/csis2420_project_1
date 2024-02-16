### Heap Sort

1.

- Big O
  
  In the worst cases, for `n = 4`, `n = 6` and `n = 8`, we see a growth of `6`, `12` and `20` comparisons respectively. This indicates that the growth is faster than linear, but not quite quadratic. Indicating `O(n log n)`. 

- Big Omega

  In the best cases, for `n = 4`, `n = 6` and `n = 8`, the growth of comparisons is `2`, `5`, and `11`. Indicating `O(n log n)`.

- Big Theta

  Because both best and worst cases indicate the same complexities of `O(n log n)`, the average case suggests `O(n log n)` as well.

2.

The performance stays relatively the same for best, worst, and average, indicating that Heap Sort has a stable performance with different permutations.


3.

for `n = 12`, we can calculate the expected number of comparisons with `O(n log n)` due to the best, worst, and average cases:

Comparisons = `avg growth rate * 12 * log_2(12)`.

- Worst
  for `n = 4`, `n = 6` and `n = 8` gives a growth rate `.75`, `.77`, `.83`.
  
  `n = 12` results in approximately 34 comparisons.
- Best
  for `n = 4`, `n = 6` and `n = 8` gives a growth rate `.25`, `.32`, `.46`.
  
  `n = 12` results in approximately 15 comparisons.
- Average
  for `n = 4`, `n = 6` and `n = 8` gives a growth rate `.5`, `.58`, `.63`.
  
  `n = 12` results in approximately 24 comparisons.


  
