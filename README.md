Unscramble App
===================================

Starter code for Android Basics codelab - Store the data in a ViewModel

Unscramble is  a single player game app that displays scrambled words. To play the game, player has
to make a word using all the letters from the displayed scrambled word.

Used in the [Android Basics with Kotlin](https://developer.android
.com/courses/android-basics-kotlin/course) course.


Pre-requisites
--------------

You need to know:
- Knowledge about Fragments.
- How to design a layout in ConstraintLayout.
- Able to write control flow statements (if / else, when statements).
- Able to update the UI of the app based on user input.
- Able to add a click listener to a Button.


Getting Started
---------------

1. Download and run the app.


Apuntes 
--------------

### Capa de datos
La capa de datos contiene *datos de la aplicación* y *lógica empresarial*. La lógica empresarial esta compuesta por reglas empresariales que determinan como se deben crear, almacenar y cambiar los datos de una aplicación

### Capa de la UI
La función de esta capa es mostrar los datosde la app en la pantalla y servir como punto principal de interacción con el usuario. Cuando los datos cambian, ya sea debido a la interacción del usuario (como cuando presiona un botón) o una entrada externa (como una respuesta de red), la IU debe actualizarse para reflejar los cambios. La UI es *una representación visual del estado de la app, tal como se recuperó de la capa de datos*  

La capa de la UI convierte los datos recibidos de la capa de datos en un formato que puede presentar y, luego, mostrar

### Capa de dominio
La capa de dominio es responsable de encapsular la lógica empresarial compleja o simple que uno o varios **ViewModels** reutilizan. No todas las apps tiene capa de dominio, esta se usa solo cuando sea necesario, por ejemplo, para administrar lógica compleja o favorer la reutilización.  


La capa de dominio brinda los siguientes beneficios:
  1. Evita la duplicidad de codigo
  2. Mejora la legibilidad en las clases que usan las de la capa de dominio.
  3. Mejora la capacidad de prueba de la app.
  4. Evita las clases grandes, ya que te permite dividir las responsabilidades.


---------


License
-------

Copyright (C) 2020 The Android Open Source Project.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.

