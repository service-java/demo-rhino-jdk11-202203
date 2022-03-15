function andIf(sql, arg) {
  if (!arg) {
    return ''
  }
  if (Object.prototype.toString.call(arg) === '[object Array]' && arg.length == 0) {
    return ''
  }

  const hasAnd = sql.trimLeft().startsWith('and')
  return `${hasAnd ? ' ' : ' and'} ${sql}`
}

// function andInIf(arg) {
//   return `and ${joinIn(arg)}`
// }


function joinIn(list) {
  if (list && list.length > 0) {
    return `(${list.join(',')})`
  }

  return '';
}

function test() {
  return `${student.name} -- ${student.age}`;
}

function selectArg(argIds) {
  return `select * 
      from user 
      where 1=1

    ${andIf(`and ids in ${joinIn(argIds)}`, argIds)}
    ${andIf(`and name <> 'Jack'`, !isOk)}
  `;
}

function select() {
  return `select * 
      from user 
      where 1=1

      ${andIf(`and ids in ${joinIn(ids)}`, ids)}
      ${andIf(`and name <> 'Jack2'`, !isOk)} 
  `;
}
