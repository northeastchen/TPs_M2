<result>{
	for $v in distinct-values(
		for $maFourniture in //fourniture
		where
			some $c in $maFourniture/P satisfies $c = 'p4'
		return
			$maFourniture/F
	) return <F>{$v}</F>
}
</result>