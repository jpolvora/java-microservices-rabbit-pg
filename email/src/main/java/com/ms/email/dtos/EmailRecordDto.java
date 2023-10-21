package com.ms.email.dtos;

import java.util.UUID;

//{"userId": "1a1f5395-98fe-4fd2-bb5c-31c61f384ec1", "emailTo": "teste@teste.com", "subject": "assunto", "text": "conteudo"}

public record EmailRecordDto(UUID userId,
                             String emailTo,
                             String subject,
                             String text) {}
