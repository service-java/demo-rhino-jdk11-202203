function test() {
  return `${student.name} -- ${student.age}`;
}

function select() {
    return `select * 
      from user 
      where 1=1
      
      ${ids && ids.length > 0 ? ` and ids in (${ids})` : ''}

      ${!isOk ? ` and name <> 'Jack'` : ''} `;
}

// function select() {

//     return `select * 
//       from user 
//       where 1=1
      
//       ${ids && ids.length > 0 ? ` and ids in (${ids.join(",")})` : ''}
  
//       ${!isOk ? ` and name <> 'Jack'` : ''} `;
//   }