package com.example.fp_bpii

data class FaqItem(
val question: String,
val answer: String,
var isExpanded: Boolean = false
)

