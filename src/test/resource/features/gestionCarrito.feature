
Feature: Yo como cliente deseo realizar compras mediante el carrito

  Scenario: Elegir un producto disponible y comprarlo
    Given un cliente abre el sitio web de New Experience
    When  Busca un vestido 'dress' y selecciona uno para comprarlo
    Then  el carro de compras debe terminar el proceso con un not 'null'
