========================
DESCRIÇÃO DA SAÍDA DE CONSTRUÇÃO
========================

Quando você cria um projeto de aplicativo Java que tem uma classe principal, o IDE
copia automaticamente todo o JAR
arquivos no classpath de projetos para a pasta dist/lib de seus projetos. O IDE
também adiciona cada um dos arquivos JAR ao elemento Class-Path no aplicativo
Arquivos JAR arquivo de manifesto (MANIFEST.MF).

Para executar o projeto a partir da linha de comando, vá para a pasta dist e
digite o seguinte:

java -jar "System.jar"

Para distribuir este projeto, compacte a pasta dist (incluindo a pasta lib)
e distribua o arquivo ZIP.

Notas:

* Se dois arquivos JAR no classpath do projeto tiverem o mesmo nome, apenas o primeiro
O arquivo JAR é copiado para a pasta lib.
* Somente arquivos JAR são copiados para a pasta lib.
Se o caminho de classe contiver outros tipos de arquivos ou pastas, esses arquivos (pastas)
não são copiados.
* Se uma biblioteca no classpath do projeto também tiver um elemento Class-Path
especificado no manifesto, o conteúdo do elemento Class-Path deve estar em
o caminho do tempo de execução dos projetos.
* Para definir uma classe principal em um projeto Java padrão, clique com o botão direito do mouse no nó do projeto
na janela Projetos e escolha Propriedades. Em seguida, clique em Executar e insira o
nome da classe no campo Classe Principal. Alternativamente, você pode digitar manualmente o
nome da classe no elemento Main-Class do manifesto.
