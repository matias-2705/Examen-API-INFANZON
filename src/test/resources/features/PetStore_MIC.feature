Feature: PetStore-MIC

  @TestEjecucion
  Scenario Outline: Crear una Orden — POST
    Given defino la URL "https://petstore.swagger.io/v2/"
    When creo una orden con id <id> y idmascota <idmascota>
    Then valido el codigo de respuesta sea <statusCode>
    And valido que el status de la orden sea "placed"

    Examples:
      | id      | idmascota | statusCode |
      | 100     | 10        | 200        |
      | 101     | 11        | 200        |
      | 102     | 5         | 200        |
      | 103     | 20        | 200        |
  @TestEjecucion
  Scenario Outline: Consultar una Orden — GET
    Given defino la URL "https://petstore.swagger.io/v2/"
    When consulto la orden de ID <id>
    Then valido el codigo de respuesta sea <statusCode>
    And valido que el campo id sea <id>

    Examples:
      | id      | statusCode |
      | 100     | 200        |
      | 101     | 200        |
      | 102     | 200        |
      | 103     | 200        |
