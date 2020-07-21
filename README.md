# Descripción Tarefa
Imos realizar unha pequena aplicación que simule unha tenda virtual. Polo momento non vimos persistencia de datos, polo que só nos fixaremos na interface e o seu funcionamento. A continuación temos unha descipción do que debe facela aplicación.

1. Ao abrir a aplicación aparecerá unha pantalla de login.
    - Nela debemos poder elixir entre autenticarse como cliente ou como administrador.
    - Ao non ter persistencia de datos, como cliente autenticarase ao utilizar o usuario “cliente1” e o contrasinal “abc123.”
e para o adminsitrador como usuario “admin” e contrasinal “abc123.”.
2. Imos coa parte do cliente, nada máis entrar veremos o seu nome (NomeA Apelido1A Apelido2A) coa súa foto
(utiliza unha calquera). 
    - Para a foto, elixe un tamaño dependendo das dimensións da pantalla.
    - Ademais deberá ter catro botóns: “Facer pedido”, “Ver pedidos en trámite”, ver "Ver compras realizadas" e “Saír”.

    - Ao premer en “Facer pedido” teremos unha pantalla con dous spinners.
         - O primeiro deles será para elixir a categoría e o segundo para elixir o producto.
        - Segundo cambiemos a categoría, os productos do segundo spinner variarán. Estas son as categorías cos seus respectivos productos:

            - Informática: PC de Sobremesa, Portatil e Monitor.
            - Electrónica: Televisión e DVD.
            - Móbiles: Pixel, Galaxy, Iphone e Xiaomi.

        - Tras ter selecionado o pedido tamén teremos que elixir a cantidade de dese producto que se comprará. 
            - Polo momento a cantidade poderá ser entre 1 e 5. 
            - Por último teremos un botón “Seguinte”. 
            - Ese botón levaranos a unha nova pantalla na que se indicará a dirección a cal se enviará o pedido, a cidade e o código postal. 
            - Esta pantalla conterá o botón Finalizar. Ao premelo mostrarase unha Toast co resumo da compra (categoría, producto, cantidade, dirección, cidade e código postal) e enviaranos a pantalla de inicio do cliente. De momento, a aplicación non ten que gardar nada.

Se na pantalla de inicio prememos en “Ver Pedidos en trámite” iremos a unha pantalla onde se vexa só un título: “Ver pedidos en trámite”. 
O mesmo pasa ao premer no botón “Ver compras realizadas”.

Para rematar co cliente só nos queda o botón “Saír” que nos enviará a pantalla de Login.

Cando iniciemos sesión como administrador teremos a mesma pantalla inicial que o cliente pero sen ningún botón. O nome do administrador é (NomeB Apelido1B Apelido2B) e utilizades unha foto calquera para este usuario.

O deseño decidídelo vos. Intentade que sexa o máis usable posible. Probade que se vexa correctamente en distintos tipos de pantalla, así como en vertical e horizontal.