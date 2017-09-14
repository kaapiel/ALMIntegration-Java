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

Para o perfeito funcionamento do framework, faz-se necessário alguns padrões:

- Caso de teste (classe) - SPRINTxx_ESTORIAxx_CTxxx.java
- Suite de teste (classe) - Suit_SPRINTxx_ESTORIAxx.java


- Todos os testes (@ Test) devem herdar CustomerTestCase (que contém os métodos @ Before e @ After) para gerenciar a integração com o ALM (passar testes, realizar upload de evidencias, etc).
- No fim de cada step (@ Step) deve-se utilizar o método de atualização dos steps do ALM updateRunStepStatus(getRunIdsList().get(stepOrder++)); Além disso, dentro de todo o tratamento de exceção deve-se conter a atualização do teste (failed ou passed) - currentRunStep.setField(RunStep.FIELDS.STATUS, "Passed");
- Todos os testes devem conter @ Step("Descrição do Step")



## 5 - Estruturas de execuções ##

A execução da suite de testes deverá ocorrer através da classe
#### PlayTestCases.java ####
- Esta classe é responsável por executar os testes das suítes. Só serão visto os resultados e evidencias no ALM se executados diretamente desta classe.
- Testes executados "unitariamente" não serão refletidos no ALM, apenas nas evidencias locais.
- Através do método playSuit(testSetId, SuitClass) é realizada a execução dos testes. Utilizar este método dentro do try catch vazio da classe PlayTestCases.java



## 6 - Evidências ##

Em tempo de execução são gerados os 'prints' das evidencias e armazenados na pasta criada chamada 'evidencias'.
Após o término de cada teste, é gerado um arquivo word (.odt) com um template pré-definido.
Neste arquivo contém todos os prints do teste que a logica do framework gerou para criar o arquivo de evidencia.

- Ao término de execução de suítes, é criada uma pasta chamada "evidenciasConsolidadas". Dentro desta pasta é possível ver todas as execuções de suítes que foram executadas. Lá também será possível visualizar todas as evidencias individualmente separadas pelas pastas "PASSED" ou "FAILED".
- Todo término de execução de suíte de testes é gerado um arquivo excel com todos os dados de execução, dentre eles tempo individual de teste, percentual de testes OK, trace de erro, mensagens e afins. Este arquivo é enviado por email automaticamente para o endereço eletrônico configurado no arquivo de configurações.

## ADB ##

Os testes mobile exigem um certo conhecimento em linha de comandos. 
Caso seja necessário, será possível também a execução dos testes mobile sem a utilização do cabo USB.
Para mais informações e comando, acesse http://adbshell.com/commands.
Seguem alguns comandos ADB que podem ser úteis (android):

- adb devices | adb tcpip 5555 | adb connect #.#.#.#
- adb shell input text "insert%syour%stext%shere"
- adb shell 'pm list packages -f |grep packageName
- adb shell monkey -p your.app.package.name -c android.intent.category.LAUNCHER 1
