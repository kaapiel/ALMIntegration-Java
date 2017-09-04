# ALMIntegration #

Este é um projeto de integração de testes (java) com a ferramena ALM da HP. Através desta integração é possível criar novas 'Runs', 
atualizar o status de uma 'Test Instance', fazer o upload de evidências e etc.

### Este é um repositório privado. Apenas pessoas autorizadas podem realizar alterações. ###

* ALM Integration tests com Java
* v0.01
* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)

### O que precisamos ter em mente antes de iniciar as configurações? ###

* 1 - HMLEnv|TIEnv & NEW|OLD params
* 2 - XML Settings file - alm project, credentials...
* 3 - Estruturas & Tecnologias
* 4 - Estruturas de suites e testes
* 5 - Estruturas de execuções
* 6 - Evidências

### Contribua conosco ###

* Escreva melhorias tanto no framework como na estrutura dos testes
* A nossa política de code review está em construção

### Entre em contato ###

* Owner/Admin - Gabriel Aguido Fraga



## 1 - HMLEnv|TIEnv & NEW|OLD params ##

Utilizamos no projeto arquivos XML para definir todos os tipos de constantes ou variáveis mutáveis. 
Repare que existem dois arquivos em nossa estrutura, um chamado HMLEnv.xml e outro chamado TIEnv.xml. Nestes arquivos
contém configurações de ambientes (Homologação e teste integrado respectivamente). Caso seja necessário criar mais 
arquivos de configurações de ambientes basta apenas seguir o mesmo modelo.

Repare também que existem dois arquivos, um chamado oldALM.xml e outro chamado newALM.xml. Nestes arquivos podemos 
encontrar os 'test set id' das suites de testes do ALM. Caso hajam outras versões de ALM podem ser acrescentados
novos arquivos.

- HMLEnv | TIEnv - Neste XML temos as seguintes informações:
	- MainFrame
		- Credenciais
		- IP | PORTA
	- Banco de dados
		- Credenciais
		- IP | PORTA
	- Identificadores web
		- Credenciais
		- XPaths, Ids, etc
	- Identificadores web services
		- Credenciais | Client id
		- Endpoints
		
- newALM | oldALM - Neste XML temos as seguintes informações:
	-  Sprint
		- Estória
			- Test Set Id
			
Ao executar o arquivo gerado .jar (gera-se um arquivo com todas as dependências internas) passa-se os parâmetros do ambiente e da 
versão do ALM a ser executadas.
#### Ex.: 'java -jar JarName.java HMLEnv NEW'. ####
Após criar a sua estrutura de tags do arquivo ALM (old ou new), acesse o site http://pojo.sodhanalibrary.com/ para poder gerar os
objetos java e colocá-los no pacote de customização.
			
			
			
## 2 - XML Settings File ##

No arquivo Settings.xml se encontram todas as configurações gerais do projeto. Na primeira tag chamada 'Env' se encontra o valor do 
ambiente de testes onde realizaremos as nossas execuções. Este valor deve ser exatamente como está o nome do arquivo, ex.: HMLEnv.

- Settings - Neste XML temos as seguintes informações:
	- Enviroment
	- Configurations
		- ALM Configurations
			- Credenciais
			- Configurações
		- Evicências
			- Configurações
		- Email
			- Credenciais
			- HOST | PORTA
		- Paths
		- Mensagens



## 3 - Estruturas & Tecnologias ##

Estas são as tecnologias e estruturas que utilizamos no projeto:

+ Java 8, Log4j, JUnit, Apache POI, AShot QATools
+ Maven, Maven Assembly Plugin - jar-with-dependencies
+ Selenium, Serenity BDD, Appium
+ Hibernate, JDBC
+ PW3270 - Windows



## 4 - Estruturas de suites e testes ##

