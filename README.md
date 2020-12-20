# Projeto Smart Chess Board

Projeto feito para a disciplina de Redes de computadores 'A', com foco
em implementar um cliente e servidor TCP e UDP com uma ideia criativa.

## Ideia
Um tabuleiro de xadrez que identifica os lances dos jogadores e envia para um servidor TCP/UDP. 
Assim fazendo com que os jogadores possam rever as jogadas feitas no tabuleiro utilizando de notação agébrica.

___
### Cliente TCP/UDP e Servidor TCP/UDP (JAVA)
Um controlador que identifica as jogadas feitas no tabuleiro, envia ao servidor que registra as jogadas em um banco SQLite.
O cliente pode declarar um vencedor ao final da partida.
![server/client](https://i.ibb.co/VNfvbCV/image.png)
___

### Aplicação web (PHP)
Feita para os jogadores poderem acessar os jogos e realizar uma análise posterior dos jogos.

![webapp](https://i.ibb.co/8B3cf6p/photo5113918711131121816.jpg)
