# Develcode-cadastro-basico

### Cadastro básico de usuário com envio de imagem


|Arquivo: | Comentário |
| :---: | :---: |
| src/main/resources/script_tabela | Script usado para criar a tabela no banco MySql. |
| src/main/resources/Develcode.postman_collection.json | Collection do postman utilizada para acessar os endpoints. |
| src/main/resources/img/cachorros.jpg | Imagem usada para o envio no postman. |

### Projeto:
Para esse projeto de cadastro básico de usuário, foi utilizado: **Java 8, Spring Boot e banco de dados MySQL.**
A solução para o problema foi o desenvolvimento de uma classe que codifica a foto enviada via cadastro (POST) ou atualização (PUT) em um arquivo de Base64 e salva na base em uma coluna de tipo BLOB, enquanto as funcionalidades de buscar e listar (GET) decodificam o arquivo retornando-o no formato Base64, que pode ser utilizado através da tag HTML <img>.

### Limitação:
Essa solução possui a limitação de aceitar apenas imagens pequenas (50kb), há maneira de superar isso porém ainda assim haveria uma limitação por causa do arquivo de Base64.

### Possível Solução:
Uma melhor solução seria salvar a imagem em um bucket no S3 da AWS e o seu caminho no banco de dados. Quando necessário, buscar pelo caminho do bucket a imagem.

### Resultados
#### Listar Usuário
<div align="center">
     <img src="https://github.com/lucasfogagnoli/develcode-cadastro-basico/blob/main/src/main/resources/img/listarUsuario.png" height="706" width="1250" alt="Listar Usuários"/>
</div>

#### Buscar Usuário
<div align="center">
     <img src="https://github.com/lucasfogagnoli/develcode-cadastro-basico/blob/main/src/main/resources/img/buscarUsuario.png" height="706" width="1250" alt="Buscar Usuários"/>
</div>

#### Cadastrar Usuário
<div align="center">
     <img src="https://github.com/lucasfogagnoli/develcode-cadastro-basico/blob/main/src/main/resources/img/cadastrarUsuario.png" height="707" width="1250" alt="Cadastrar Usuários"/>
</div>

#### Atualizar Usuário
<div align="center">
     <img src="https://github.com/lucasfogagnoli/develcode-cadastro-basico/blob/main/src/main/resources/img/atualizarUsuario.png" height="708" width="1250" alt="Atualizar Usuários"/>
</div>

#### Deletar Usuário
<div align="center">
     <img src="https://github.com/lucasfogagnoli/develcode-cadastro-basico/blob/main/src/main/resources/img/deletarUsuario.png" height="430" width="1250" alt="Deletar Usuários"/>
</div>
