function logar(){    
   const headers = new Headers();
   headers.append('Content-Type', 'application/json') 

   fetch('http://localhost:8080/auth/login',
      {
         method: 'POST',
         headers: headers,
         body: JSON.stringify( {email: document.getElementById('email').value,
                              password: document.getElementById('senha').value})
      }) 
      .then(data => data.text())
      .then(response => {
          if(response != ''){
            sessionStorage.setItem('token', response )
            verificaSeLogado() 
          } else{
            alert("usuario e senha incorretos")
          }
                   
      })      
  } 
  
  function RegistrarUser(){
      const headers = new Headers();
      headers.append('Content-Type', 'application/json')   
           
      let obj = {
                  email: document.getElementById('user').value,
                  password: document.getElementById('pass').value,
                  role: document.getElementById('role').value
              }
       fetch('http://localhost:8080/auth/register',
          {
             method: 'POST',
             body: JSON.stringify(obj),
             headers: headers
          }
       )
      .then( x => {
          document.getElementById('registrar').style="display:none"
          document.getElementById('login').style="display:block" 
      })  
      .catch(error => console.log(error))
  }   
  
  function decodificaTokenJwt(token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}

function verificaSeLogado(){
  let token =  sessionStorage.getItem('token')
  if(token != null){
    let userLogado = decodificaTokenJwt(token)
    document.getElementById("userLogado").innerHTML = `Olá, ${userLogado.sub}`
    document.getElementById("userLogado").style='display:block'
    document.getElementById("logout").style='display:block'
  }
  else{
    document.getElementById("userLogado").style='display:none'
    document.getElementById("logout").style='display:none'
  }
}

function logout(){
    sessionStorage.removeItem('token')
    verificaSeLogado()
}