package application.controller.relatorio.template;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.tableOfContentsCustomizer;
import static net.sf.dynamicreports.report.builder.DynamicReports.template;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.dynamicreports.report.base.expression.AbstractValueFormatter;
import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.datatype.BigDecimalType;
import net.sf.dynamicreports.report.builder.style.BorderBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;
import net.sf.dynamicreports.report.definition.ReportParameters;

public class Templates {

	private static final int logoCabecalhoX = 60;
	private static final int logoCabecalhoY = 60;

	private static String logoCabecalho = "resources/logo.jpg";
	private static String NOME = "Sistema Mapa de Bordo";
	private static String TEXTO1 = "Projeto banco de dados 01";
	private static String TEXTO2 = "";
	private static String TEXTO3 = "Alunos: Gabriel Muller, Gustavo Nemeth";
	// Informações Rodap�
	private static String logoRodape = "logo.jpg";
	private static final int logoRodapeX = 130;
	private static final int logoRodapeY = 30;
	private static final String textoRodape = "";

	private static final String formatacaoData = "dd/MM/yyyy hh:mm";

	// Configurações de layout
	public StyleBuilder rootStyle;
	public StyleBuilder boldStyle;
	public StyleBuilder italicStyle;
	public StyleBuilder boldCenteredStyle;
	public StyleBuilder bold12CenteredStyle;
	public StyleBuilder bold16CenteredStyle;
	public StyleBuilder bold18CenteredStyle;
	public StyleBuilder bold22CenteredStyle;
	public StyleBuilder bold26CenteredStyle;
	public StyleBuilder columnStyle;
	public StyleBuilder columnTitleStyle;
	public StyleBuilder groupStyle;
	public StyleBuilder subtotalStyle;
	public StyleBuilder centered;
	public StyleBuilder bold12LeftStyle;
	public StyleBuilder rodapeDireita;
	public StyleBuilder boldGroup;
	public String inteiroSemVirgula;
	private BorderBuilder bordaTitulo;
	public StyleBuilder tituloColuna;
	public StyleBuilder regular10;

	public Templates() {

		rootStyle = stl.style().setPadding(2);
		boldStyle = stl.style(rootStyle).bold();
		italicStyle = stl.style(rootStyle).italic();
		boldCenteredStyle = stl.style(boldStyle).setTextAlignment(HorizontalTextAlignment.CENTER,
				VerticalTextAlignment.MIDDLE);
		regular10 = stl.style(rootStyle).setFontSize(10);
		bold12CenteredStyle = stl.style(boldCenteredStyle).setFontSize(12);
		bold16CenteredStyle = stl.style(boldCenteredStyle).setFontSize(16);
		bold18CenteredStyle = stl.style(boldCenteredStyle).setFontSize(18);
		bold22CenteredStyle = stl.style(boldCenteredStyle).setFontSize(22);
		bold26CenteredStyle = stl.style(boldCenteredStyle).setFontSize(26);
		columnStyle = stl.style(rootStyle).setVerticalTextAlignment(VerticalTextAlignment.MIDDLE);
		columnTitleStyle = stl.style(columnStyle).setBorder(stl.pen1Point())
				.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER).setBackgroundColor(Color.LIGHT_GRAY).bold();
		groupStyle = stl.style(boldStyle).setHorizontalTextAlignment(HorizontalTextAlignment.LEFT);
		subtotalStyle = stl.style(boldStyle).setTopBorder(stl.pen1Point());
		centered = stl.style().setTextAlignment(HorizontalTextAlignment.CENTER, VerticalTextAlignment.MIDDLE);
		rodapeDireita = stl.style().setTextAlignment(HorizontalTextAlignment.RIGHT, VerticalTextAlignment.JUSTIFIED);
		boldGroup = stl.style(boldStyle).setFontSize(22).setTextAlignment(HorizontalTextAlignment.LEFT,
				VerticalTextAlignment.MIDDLE);
		bold12LeftStyle = stl.style().setFontSize(12).setHorizontalTextAlignment(HorizontalTextAlignment.LEFT).bold();
		inteiroSemVirgula = "#";
		bordaTitulo = stl.border().setBottomPen(stl.penThin().setLineColor(Color.WHITE))
				.setLeftPen(stl.penThin().setLineColor(Color.WHITE)).setTopPen(stl.penThin().setLineColor(Color.WHITE));
		tituloColuna = stl.style().setBorder(bordaTitulo).setFontSize(12).bold()
				.setTextAlignment(HorizontalTextAlignment.CENTER, VerticalTextAlignment.MIDDLE);
	}

	public ComponentBuilder<?, ?> criarCabecalho() {

		return cmp
				.horizontalList(cmp.image(logoCabecalho).setFixedDimension(logoCabecalhoX, logoCabecalhoY),
						cmp.verticalList(
								cmp.text(NOME).setStyle(bold16CenteredStyle).setHorizontalTextAlignment(
										HorizontalTextAlignment.LEFT),
								cmp.text(TEXTO1).setStyle(regular10), cmp.text(TEXTO2).setStyle(regular10),
								cmp.text(TEXTO3).setStyle(regular10)))
				.setFixedWidth(300);
	}

	public ComponentBuilder<?, ?> createTitleComponent(String label) {

		return cmp.horizontalList()
				.add(criarCabecalho(),
						cmp.text(label).setStyle(bold16CenteredStyle)
								.setHorizontalTextAlignment(HorizontalTextAlignment.RIGHT))
				.newRow().add(cmp.line()).newRow().add(cmp.verticalGap(10));
	}

	/*
	 * Rodapé
	 */
	public ComponentBuilder<?, ?> createFooterComponent(boolean logo) {
		return cmp
				.verticalList(cmp.horizontalList(cmp.text(new SimpleDateFormat(formatacaoData).format(new Date())),
						cmp.image(Templates.class.getClassLoader().getResource(logoRodape))
								.setFixedDimension(logoRodapeX, logoRodapeY).setStyle(centered),
						cmp.text(textoRodape).setStyle(rodapeDireita)), cmp.pageXofY())

				.setStyle(stl.style(boldCenteredStyle).setTopBorder(stl.pen1Point()));
	}

	public ReportTemplateBuilder criarReportTemplate() {

		PageType pageType = PageType.A4;

		StyleBuilder crosstabGroupStyle = stl.style(columnTitleStyle);
		StyleBuilder crosstabGroupTotalStyle = stl.style(columnTitleStyle).setBackgroundColor(new Color(170, 170, 170));
		StyleBuilder crosstabGrandTotalStyle = stl.style(columnTitleStyle).setBackgroundColor(new Color(140, 140, 140));
		StyleBuilder crosstabCellStyle = stl.style(columnStyle).setBorder(stl.pen1Point());

		TableOfContentsCustomizerBuilder tableOfContentsCustomizer = tableOfContentsCustomizer().setHeadingStyle(0,
				stl.style(rootStyle).bold());

		return template().setLocale(Locale.ENGLISH).setColumnStyle(columnStyle).setColumnTitleStyle(columnTitleStyle)
				.setGroupStyle(groupStyle).setGroupTitleStyle(groupStyle).setSubtotalStyle(subtotalStyle)
				.highlightDetailEvenRows().crosstabHighlightEvenRows().setCrosstabGroupStyle(crosstabGroupStyle)
				.setCrosstabGroupTotalStyle(crosstabGroupTotalStyle).setCrosstabGrandTotalStyle(crosstabGrandTotalStyle)
				.setCrosstabCellStyle(crosstabCellStyle).setTableOfContentsCustomizer(tableOfContentsCustomizer)
				.setPageFormat(pageType);
	}

	public CurrencyValueFormatter createCurrencyValueFormatter(String label) {
		return new CurrencyValueFormatter(label);
	}

	public class CurrencyType extends BigDecimalType {
		private static final long serialVersionUID = 1L;

		@Override
		public String getPattern() {
			return "$ #,###.00";
		}
	}

	private class CurrencyValueFormatter extends AbstractValueFormatter<String, Number> {
		private static final long serialVersionUID = 1L;

		private String label;

		public CurrencyValueFormatter(String label) {
			this.label = label;
		}

		public String format(Number value, ReportParameters reportParameters) {
			return label + new CurrencyType().valueToString(value, reportParameters.getLocale());
		}
	}

}
