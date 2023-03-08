# Assignment 3

## Problem ?. Safe Areas in RA2(Easy, ? points)

Recently, thanks to a series of video uploaders such as WM=HBK08 and =HY=Moon3, Red Alert 2 becomes a popular game in China. Suppose you are an Engineer(提包哥) in the $n*n$ battlefield of Red Alert 2, and there are $m$ Desolators(辐射工兵) and $k$ Grand Cannons(巨炮) of enemies. Now you are given the positions of Desolators and Grand Cannons and need to find out the number of safe areas in the battlefield.

Here is the introduction to Desolators and Grand Cannons in this problem:

- Desolator: The Desolator uses a radiation cannon to irradiate the ground around him(blocks in green), damaging all units around him.

![image](https://user-images.githubusercontent.com/64548919/223599396-d57b7510-a661-4b4d-baed-11ac6ebfcd73.png)


- Grand Cannon: The Grand Cannon is a larse artillery gun firing powerful heavy shells to an extreme range and causes considerable damage in the target area(blocks in red). However, it has a minimum range and cannot damage the enemy around it.

![image](https://user-images.githubusercontent.com/64548919/223598956-fc4a66eb-3665-47ba-94b4-5894839afd0b.png)

### Input Format

The first line gives $n,m,k$.

Then the following $m$ lines define $x_i,y_i$, the positions of Desolator.

Then following $k$ lines define $o_i,p_i$, the positions of Grand Cannons.

### Output Format

The number of safe areas in the battlefield of Red Alert 2.

### Sample with Explanation

**Input**

```text
5 2 2
3 0
1 2
0 0
3 4
```

**Output**
```text
6
```

**Explanation**

![image](https://user-images.githubusercontent.com/64548919/223601583-b12bfab4-c385-408d-8bf3-a83c5b87f45d.png)

The battlefield is shown in the figure. The blocks in green are irradiated by Desolators and those in red can be damaged by Grand Cannons. The blocks in yellow can be both damaged by Desolators and Grand Cannons.
Considering (0,0) and (3,4) are captured by Grand Cannons, there are 6 safe areas i.e. (0, 4), (1, 0), (2, 4), (3, 3), (4, 3) and (4, 4).

### Hint

1. You can try to make use of `boolean[][]`.
2. It is recommended to do the boundary checking before accessing array element.
3. Test data scale:

- For $10\%$ testcases, $n = 1$; 
- For another $20\%$ testcases, $m = 0$ or $k = 0$; 
- For $100\%$ testcases, $1 \le n \le 100$, $0 \le m,n \le 25$, $0 \le m+n \le 25$;

## Problem ?. Compressed Spiral Matrix(Hard, ? points)

In this problem, you are required to fill in the matrix of size $m × n$.
You are given matrix size $m$, $n$ and a compressed String $s$ containing lower letters and numbers. 
And you need to do the following tasks in this problem:

(1) Decompress the compressed String. The String s is compressed in the form of letters $c_i$ and repeat times $n_i$. After decompression, the length of String $s'$ is guaranteed to equal $m*n$ in our testcases. For instance, `a6` can be decompressed into `aaaaaa` since $c_0=a$ and $n_0=6$, and `a1b4` can be decompressed into `abbbb` since $c_0=a$ and $n_0 = 1$, $c_1=b$ and $n_1=4$.

(2) Organize the sqiral matrix counterclockwise using the decompressed String $s'$, starting from the bottom left corner.

![image](https://user-images.githubusercontent.com/64548919/223476252-46beba66-8c0e-49ea-a194-1ec4a83e8429.png)

(3) Print out the alphabet matrix after decompression.

### Input Format
The first line gives $m$ and $n$, and the second line gives the compressed String $s$.

### Output Format

The sqiral matrix after decompression.

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
- For another $10\%$ testcases, there is only $c_0$ and $n_0$ in the compressed String $s$.
- For $20\%$ testcases, $m = 1$ or $n = 1$ for the target matrix size; 
- For $60\%$ testcases, $n_i \lt 10$ for the compressed String $s$; 
- For $100\%$ testcases, $m,n \le 200$ for the target matrix size and $n_i \le 100$ for the compressed String $s$;