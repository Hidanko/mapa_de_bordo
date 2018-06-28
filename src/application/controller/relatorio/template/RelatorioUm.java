package application.controller.relatorio.template;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

import java.util.List;

import application.controller.relatorio.model.DadosRelatorioUm;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;

public class RelatorioUm {

	public synchronized void gerarRelatorio(List<DadosRelatorioUm> lista) {
		Templates templates = new Templates();
		try {

			report().setTemplate(templates.criarReportTemplate())
					.columns(col.column("Mes", "mes", type.integerType()).setStyle(templates.centered),
							col.column("Ano", "ano", type.integerType()).setStyle(templates.centered),
							col.column("Numero de Viagens", "viagens", type.integerType()).setStyle(templates.centered),
							col.column("Numero de Embarcações", "embarcacoes", type.integerType())
									.setStyle(templates.centered),
							col.column("Total Capturado", "total", type.doubleType()).setStyle(templates.centered))
					.title(templates.createTitleComponent("Relatorio 01")).setDataSource(criarDatasource(lista)).show();

		} catch (DRException e) {
			System.out.println("ERRO");
			e.printStackTrace();
		}
		System.out.println("FINALIZADO");
	}

	private DRDataSource criarDatasource(List<DadosRelatorioUm> lista) {

		DRDataSource datasource = new DRDataSource("mes", "ano", "viagens", "embarcacoes", "total");

		for (DadosRelatorioUm objeto : lista) {
			datasource.add(objeto.getMes(), objeto.getAno(), objeto.getNúmeroViagens(), objeto.getEmbarcaçõesQueOperaram(),
					objeto.getTotalCapturado());
		}
		return datasource;
	}

}
