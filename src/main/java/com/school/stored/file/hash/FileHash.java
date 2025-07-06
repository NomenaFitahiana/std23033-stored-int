package com.school.stored.file.hash;

import com.school.stored.PojaGenerated;

@PojaGenerated
public record FileHash(FileHashAlgorithm algorithm, String value) {}
