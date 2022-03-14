- test

```sql
${student.name} -- ${student.age}
```  

- selectArg(argIds) 

```sql
select * 
from user 
where 1=1

${argIds && argIds.length > 0 ? ` and ids in (${argIds})` : ""}

${!isOk ? ` and name <> 'Jack'` : ""} 
```

- select

```sql
select * 
from user 
where 1=1

${ids && ids.length > 0 ? ` and ids in (${ids.join(",")})` : ""}

${!isOk ? ` and name <> 'Jack'` : ""} 
```