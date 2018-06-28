package application.controller.relatorio.template;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

import java.util.List;

import application.controller.relatorio.model.DadosRelatorioDois;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;

public class RelatorioDois {

	// int mes;
	// int ano;
	// String nomeEmbarcacao;
	// int totalViagens;
	// float totalCapturado;

	public synchronized void gerarRelatorio(List<DadosRelatorioDois> lista) {
		Templates templates = new Templates();
		try {

			report().setTemplate(templates.criarReportTemplate())
					.columns(col.column("Mes", "mes", type.integerType()).setStyle(templates.centered),
							col.column("Ano", "ano", type.integerType()).setStyle(templates.centered),
							col.column("Embarcação", "embarcacao", type.stringType()).setStyle(templates.centered),
							col.column("Total Viagens", "viagens", type.integerType()).setStyle(templates.centered),
							col.column("Total Capturado", "total", type.doubleType()).setStyle(templates.centered))
					.title(templates.createTitleComponent("Relatorio 02")).setDataSource(criarDatasource(lista)).show();

		} catch (DRException e) {
			System.out.println("ERRO");
			e.printStackTrace();
		}
		System.out.println("FINALIZADO");
	}

	private DRDataSource criarDatasource(List<DadosRelatorioDois> lista) {

		DRDataSource datasource = new DRDataSource("mes", "ano", "embarcacao", "viagens", "total");

		for (DadosRelatorioDois objeto : lista) {
			datasource.add(objeto.getMes(), objeto.getAno(), objeto.getNomeEmbarcacao(), objeto.getTotalViagens(), objeto.getTotalCapturado());
		}
		return datasource;
	}
}
