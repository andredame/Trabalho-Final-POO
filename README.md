# Git Flow

Este repositório utiliza um modelo de ramificação inspirado no Git Flow para gerenciar o fluxo de trabalho do Git. O modelo de ramificação segue um conjunto consistente de ramificações e comandos para facilitar a colaboração entre equipes.

## Ramificações

Este modelo de ramificação utiliza cinco ramificações principais:

- `master`: representa a versão mais recente do código que está em produção. Essa é uma branch fixa, ou seja, não deve ser modificada diretamente.
- `develop`: representa a versão mais recente do código que está em desenvolvimento. Essa é outra branch fixa, também não deve ser modificada diretamente.
- `feature`:  é usada para desenvolver novas funcionalidades. Essa ramificação é criada a partir da ramificação `master` e cada nova funcionalidade deve ser mesclada na ramificação `develop` assim que estiver pronta.
- `release`: é usada para preparar uma nova versão para produção. Nesta ramificação, são feitos ajustes finais e testes antes de mesclar a versão final na ramificação `master`. 
- `hotfix`: é usada para corrigir problemas críticos em produção. Essa ramificação é criada a partir da ramificação `master` e deve ser mesclada tanto na ramificação `master` quanto na `develop`.

## Fluxo de trabalho

O fluxo de trabalho inspirado no Git Flow segue o seguinte fluxo:

1. Clone o repositório em sua máquina:
```bash
git clone <URL-do-repositório>
```

2. Crie uma nova branch a partir da ramificação `develop` para a funcionalidade que deseja implementar:
```bash
git checkout develop
git checkout -b feature/<nome-da-funcionalidade>
```

3. Trabalhe na nova funcionalidade e faça commits regularmente:
```bash
git commit -m "mensagem de commit"
```

4. Quando a funcionalidade estiver completa, faça push da branch para o repositório remoto e abra um pull request no GitHub para a ramificação `develop`. O pull request deve conter uma descrição clara da funcionalidade e uma lista de verificação dos testes realizados.
```bash
git push origin feature/<nome-da-funcionalidade>
```

5. Peça a outro membro da equipe para revisar o pull request e fazer quaisquer comentários ou sugestões. Faça as alterações necessárias e continue a discutir o pull request com os revisores até que esteja pronto para ser mesclado.

6. Quando o pull request for aprovado, faça o merge na ramificação `develop` diretamente no GitHub.

7. Crie uma nova branch a partir da ramificação `develop` para a release que deseja preparar:
```bash
git checkout develop
git checkout -b release/<versão>
```

8. Faça ajustes finais na release e faça push da branch para o repositório remoto e abra um pull request no GitHub para a ramificação `master`. O pull request deve conter uma descrição clara da versão a ser lançada e uma lista de verificação dos testes realizados.
```bash
git push origin release/<versão>
```

9. Peça a outro membro da equipe para revisar o pull request e fazer quaisquer comentários ou sugestões. Faça as alterações necessárias e continue a discutir o pull request com os revisores até que esteja pronto para ser mesclado.

10. Quando o pull request for aprovado, faça o merge na ramificação `master` diretamente no GitHub. Em seguida, faça o merge na ramificação `develop`.

11. Crie uma nova branch a partir da ramificação `master` para a correção de um problema crítico em produção:
```bash
git checkout master
git checkout -b hotfix/<nome-do-problema>
```

12. Corrija o problema e faça push da branch para o repositório remoto e abra um pull request no GitHub para as ramificações `master` e `develop`. O pull request deve conter uma descrição clara do problema corrigido e uma lista de verificação dos testes realizados.
```bash
git push origin hotfix/<nome-do-problema>
```

13. Peça a outro membro da equipe para revisar o pull request e fazer quaisquer comentários ou sugestões. Faça as alterações necessárias e continue a discutir o pull request com os revisores até que esteja pronto para ser mesclado.

14. Quando o pull request for aprovado, faça o merge na ramificação `master` e na `develop` diretamente no GitHub.

15. Após o merge, verifique se o problema crítico foi resolvido em produção e se não há outros problemas relacionados.

16. Exclua a branch de `hotfix` do repositório remoto e local:
```bash
git push origin --delete hotfix/<nome-do-problema>
git branch -d hotfix/<nome-do-problema>
```
