function test() {
  return `${student.name} -- ${student.age}`;
}

function selectArg(argIds) {
  return `select * 
      from user 
      where 1=1
      
      ${argIds && argIds.length > 0 ? ` and ids in (${argIds})` : ""}

      ${!isOk ? ` and name <> 'Jack'` : ""} `;
}

// function select() {
//     return `select *
//       from user
//       where 1=1

//       ${ids && ids.length > 0 ? ` and ids in (${ids})` : ''}

//       ${!isOk ? ` and name <> 'Jack'` : ''} `;
// }

function select() {
  // 方法join会报错
  return `select * 
      from user 
      where 1=1
      
      ${ids && ids.length > 0 ? ` and ids in (${ids.join(",")})` : ""}
  
      ${!isOk ? ` and name <> 'Jack'` : ""} `;
}
