Feature: Navegar a url de contacto
    Scenario: Oprimir el boton de contanto para redireccionar a contacto
      Given Para navegar hasta laa url "http://localhost:3000"
      When hacemos click en el link "/html/body/div[2]/ul/li[3]/a"
      Then Redireccionarte a la url "http://localhost:3000/Contacto"