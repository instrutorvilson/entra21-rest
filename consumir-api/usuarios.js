function logar(){    
    const headers = new Headers();
    headers.append('Content-Type', 'application/x-www-form-urlencoded');
    headers.append('Authorization', `Basic ${btoa('entra21:entra21-2023')}`); //quando acessa browser usa btoa, em node usa base64
      fetch('http://localhost:8080/oauth/token',
      {
         method: 'POST',
         headers: headers,
      body: new URLSearchParams({
            'username': document.getElementById('email').value,
            'password': document.getElementById('senha').value,
            'grant_type': 'password'
          })
      }) 
      .then(data => data.json())
      .then(response => {
          let jsonToken = JSON.stringify(response)
          sessionStorage.setItem('userLogado', JSON.parse(jsonToken).access_token )
          document.getElementById('login').style='display:none';
      }) 
      .catch(error => console.error('Error:', error));
  } 
  

  function RegistrarUser(){
      let token =  sessionStorage.getItem('userLogado')
      const headers = new Headers();
      headers.append('Authorization',`Bearer ${token}`)
      headers.append('Content-Type', 'application/json')    
           
      let obj = {
                  nome: document.getElementById('nome').value,
                  email: document.getElementById('user').value,
                  senha: document.getElementById('pass').value,
                  roles: [{id: document.getElementById('role').selectedIndex+1, authority: document.getElementById('role').value}]
              }
       fetch('http://localhost:8080/usuarios',
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