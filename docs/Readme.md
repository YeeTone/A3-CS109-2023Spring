# Assignment 3

## Problem ?. Compressed Spiral Matrix(Hard, ? points)

Now you are required to fill in the matrix of size $m × n$.
You are given matrix size $m$, $n$ and a compressed String $s$ containing lower letters and numbers. 
And you need to do the following tasks in this problem:

(1) Decompress the compressed String. The String s is compressed in the form of letters $c_i$ and repeat times $n_i$. After decompression, the length of String $s'$ is guaranteed to equal $m*n$ in our testcases. For instance, `a6` can be decompressed into `aaaaaa` since $c_0=a$ and $n_0=6$, and `a1b4` can be decompressed into `abbbb` since $c_0=a$ and $n_0 = 1$, $c_1=b$ and $n_1=4$.

(2) Organize the sqiral matrix counterclockwise using the decompressed String $s'$, starting from the bottom left corner.

![image](https://user-images.githubusercontent.com/64548919/223476252-46beba66-8c0e-49ea-a194-1ec4a83e8429.png)

(3) Print out the alphabet matrix after decompression.

### Sample with Explanation

**Input**

```text
4 5
a1b2c3d4e5f4g1
```

**Output**

```text
eeddd
egffd
eeffc
abbcc
```

**Explanation**

First, we do the decompression for the given String $s$.

```text
Before: a1b2c3d4e5f4g1
After: abbcccddddeeeeeffffg
```

Next, we start from the bottom left corner and organize the $4×5$ sqiral matrix counterclockwise using $s'$(abbcccddddeeeeeffffg).

![image](https://user-images.githubusercontent.com/64548919/223479172-4433a9a1-b90a-4353-9d54-bfa56908a81f.png)

Finally, we print the matrix out and get the output in the sample.

```text
eeddd
egffd
eeffc
abbcc
```

### Hint

1. It is recommended to use methods to simplify this problem.
2. Test data scale:

- For $10\%$ testcases, $n_i = 1$ for the compressed String $s$; 
- For another $10\%$ testcases, there is only $c_0$ and $n_0$ in the compressed String.
- For $20\%$ testcases, $m = 1$ or $n = 1$ for the target matrix size; 
- For $60\%$ testcases, $n_i \lt 10$ for the compressed String $s$; 
- For $100\%$ testcases, $m,n \le 200$ for the target matrix size and $n_i \le 100$ for the compressed String $s$;