Feature: Navegación al botón Galería
  Scenario: Acceder a la galería desde el botón principal
    Given que estoy en la página principal "http://localhost:3000"
    When hago clic en el botón de galería con xpath "/html/body/div[2]/ul/li[2]/a"
    Then debo ser redirigido a la url "http://localhost:3000/Galeria"

