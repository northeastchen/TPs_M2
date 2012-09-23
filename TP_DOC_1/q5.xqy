<result>{
	for $v in distinct-values(
		for $fournisseur in //fournisseur,
			$maFourniture in //fourniture,
			$produit in //produit
		where
			$maFourniture/F = $fournisseur/F and
			$maFourniture/P = $produit/P and
			$produit/Couleur = 'vert'
		return
			$fournisseur/F/text()
	) return <F>{$v}</F>
}
</result>