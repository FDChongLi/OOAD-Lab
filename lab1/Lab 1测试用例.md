## Lab 1测试用例 ##

### --用例 1 ### 

##### Input #####

```
A "world"
a "hello" 
s
d 3
D 5
u
u
r
s
l 3
D 5
s
D 20
s
```

##### Output #####

```
"helloworld"
"loworld"
1 r
2 u
3 u
"lo"
""
```

### --用例 2 ###

##### Input #####

```
d 3
a "the second "
A "test"
u
s
m 4 m4
m4
s
d 6
A ' end'
a 'start'
u
u
u
r
r
s
A "22"
D 1
s
l 4
```

##### Output #####

```
"the second "
"the second second "
"cond second end"
"cond second end2"
1 D 1
2 A "22"
3 r
4 r
```

### --用例 3 ###

##### Input #####

```
a "Object-Oriented Design and Analysis"
A "2020"
s
D 10
d  3
s
u
u
r
s
D 6
l 3
s
```

##### Output #####

```
"Object-Oriented Design and Analysis2020"
"ect-Oriented Design and An"
"Object-Oriented Design and An"
1 D 6
2 r
3 u
"Object-Oriented Design "
```

### --用例 4 ###

##### Input #####

```
a "Unified modeling language"
d 21
s
A “Design patterns”
m 2 m1
$m1
s
u
u
u
r
r
D 2
A “C++”
s
l 2
```

##### Output #####

```
"uage"
"Design patterns"
"uageDesign patterns"
"uageDesign patterC++"
1 A “C++”
2 D 2
```

## 分数分配说明 ##

1、本测试用例共4个，每个20分，共计80分

2、在每个测试用例中分别有5次输出（即s和l命令的输出），所以单次输出正确的话，可得4分

3、最终将分数累计得出最后得分

