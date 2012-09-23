<?xml version="1.0" encoding="UTF-8"?>
<!-- fichier recettes2page.xsl -->
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
	<xsl:output indent="yes" encoding="UTF-8" method="xml"
		doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
		media-type="text/html" />
	<xsl:template match="/">
		<html>
			<head>
				<title>RECETTES</title>
				<!-- on pourra ajouter une feuille de style CSS ici -->
				<link href="../css/page.css" rel="stylesheet" type="text/css" />
			</head>
			<body>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>


	<xsl:template match="recettes">

		<xsl:apply-templates select="rubrique/recette"
			mode="index">
			<xsl:sort select="nom" />
		</xsl:apply-templates>

		<xsl:result-document href="recettes.html">
			<html>
				<head>
					<title>Recettes</title>
				</head>
				<body>
					<h1>Recettes</h1>
					<!-- on pourra ouvrir cet apply-templates pour trier les recettes ici -->


					<xsl:apply-templates select="rubrique/recette"
						mode="details">
						<xsl:sort select="nom" />
					</xsl:apply-templates>
				</body>
			</html>

		</xsl:result-document>

	</xsl:template>


	<xsl:template match="recette" mode="index">
		<div>
			<a href="Recette-{generate-id()}.html">
				<h2>
					<xsl:value-of select="./nom" />
				</h2>
			</a>
		</div>

	</xsl:template>

	<xsl:template match="recette" mode="details">
		<!-- on pourra ajouter un attribut id sur cet élément div afin de créer 
			ensuite un lien vers chaque recette -->
		<xsl:result-document href="Recette-{generate-id()}.html">
			<html>
				<head>
					<title>Recettes</title>
				</head>
				<body>
					<h1>Recettes</h1>
					<!-- on pourra ouvrir cet apply-templates pour trier les recettes ici -->
					<div id="Recette-{generate-id()}" class="fiche">
						<h2>
							<xsl:value-of select="nom" />
						</h2>
						<p>
							<xsl:value-of select="temps/text()" />
						</p>
						<!-- on pourra considerer les ingrédients comme une liste (ul) -->
						<div class="ingrédients">
							<ul>
								<xsl:apply-templates select="ingrédients" />
							</ul>
						</div>
						<div class="préparation">
							<xsl:apply-templates select="préparation" />
						</div>
					</div>
					<br/>
					<div>
						<a href="page.html" ><h2>Accueil</h2></a>
						<a href="Recette-{preceding-sibling::div[@id]}.html"><h2>Précédent</h2></a>
						<a href="page.html" ><h2>Suivant</h2></a>
						
					</div>
				</body>
			</html>

		</xsl:result-document>

	</xsl:template>


	<xsl:template match="préparation|ingrédients">
		<h3>
			<xsl:value-of select="name()" />
		</h3>
		<xsl:apply-templates select="./item" />
	</xsl:template>

	<xsl:template match="item">
		<!-- on pourra considerer les item comme des éléments d'une liste (li) -->
		<li>
			<xsl:value-of select="./text()" />

		</li>

	</xsl:template>

</xsl:stylesheet>

