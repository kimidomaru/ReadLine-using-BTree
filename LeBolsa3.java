import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;


class LeBolsa3
{
	public static void main(String args[]) throws Exception
	{
		BTree<String, String> arvoreB = new BTree<String, String>();
		//File saida = new File("tempos.txt");
		//FileWriter tempo = new FileWriter(saida);
		String linha;
		String colunas[];
		double tempoIni, tempoFim, tempoTotal;
		RandomAccessFile f = new RandomAccessFile("bolsa2.csv", "r");
		f.readLine();
		while(f.getFilePointer() < f.length())
		{
			linha = f.readLine();
			colunas = linha.split("\t");
			arvoreB.put(colunas[7], linha);
		}
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o NIS. Ele e composto de 14 numeros: ");
		String nisInput = input.nextLine();
		tempoIni = System.nanoTime();
		String encontrou = arvoreB.get(nisInput);
		if(encontrou!=null) {
			System.out.println(encontrou);
			tempoFim = System.nanoTime();
			tempoTotal = tempoFim-tempoIni;
			System.out.println("Tempo de execucao (nanossegundos): "+tempoTotal);
			System.out.println("Nº de elementos da arvore: "+arvoreB.size());
			System.out.println("Altura da arvore: "+arvoreB.height());
		}
		else
			System.out.println("Nis nao encontrado!");
		
		
		//////////////GERANDO TXT DOS TEMPOS DE EXECUCAO DE TODAS AS LINHAS//////////////////////
		/*f.seek(0);
		while(f.getFilePointer() < f.length()) {
			linha = f.readLine();
			colunas = linha.split("\t");
			tempoIni = System.nanoTime();
			String encontrou = arvoreB.get(colunas[7]);
			if(encontrou!=null) {
				System.out.println(encontrou);
				tempoFim = System.nanoTime();
				tempoTotal = tempoFim-tempoIni;
				String temp = Double.toString(tempoTotal);
				tempo.write(temp);
				tempo.write(System.getProperty( "line.separator" ));
			}
			else
				System.out.println("Nis nao encontrado!");
		}
		tempo.close();*/
		input.close();
        f.close();
	}

}