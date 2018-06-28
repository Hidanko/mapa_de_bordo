package application.controller.relatorio.template;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

import java.util.List;

import application.controller.relatorio.model.DadosRelatorioTres;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;

public class RelatorioTres {

	public synchronized void gerarRelatorio(List<DadosRelatorioTres> lista) {
		Templates templates = new Templates();
		try {

			report().setTemplate(templates.criarReportTemplate())
					.columns(col.column("Mes", "mes", type.integerType()).setStyle(templates.centered),
							col.column("Ano", "ano", type.integerType()).setStyle(templates.centered),
							col.column("Especie", "especie", type.stringType()).setStyle(templates.centered),
							col.column("Total Capturado", "capturado", type.doubleType()).setStyle(templates.centered))
					.title(templates.createTitleComponent("Relatorio 03")).setDataSource(criarDatasource(lista)).show();

		} catch (DRException e) {
			System.out.println("ERRO");
			e.printStackTrace();
		}
		System.out.println("FINALIZADO");
	}

	private DRDataSource criarDatasource(List<DadosRelatorioTres> lista) {

		DRDataSource datasource = new DRDataSource("mes", "ano", "viagens", "embarcacoes", "total");

		for (DadosRelatorioTres objeto : lista) {
			datasource.add(objeto.getMes(), objeto.getAno(), objeto.getNome(), objeto.getCapturado());
		}
		return datasource;
	}

}
