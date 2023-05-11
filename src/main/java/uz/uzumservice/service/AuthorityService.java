package uz.uzumservice.service;

import org.springframework.stereotype.Service;
import uz.uzumservice.dto.ResponseDto;
import uz.uzumservice.repository.AuthorityRepository;

import static uz.uzumservice.service.validator.AppStatusCodes.VALIDATION_ERROR_CODE;
import static uz.uzumservice.service.validator.AppStatusMessages.DUPLICATE_ERROR;
import static uz.uzumservice.service.validator.AppStatusMessages.OK;

@Service
public record AuthorityService(AuthorityRepository authorityRepository) {
    public ResponseDto<Void> addAuthorityToUser(String username, String authorityName){
        if (authorityRepository.existsByUsernameAndAuthority(username, authorityName)){
            return ResponseDto.<Void>builder()
                    .code(VALIDATION_ERROR_CODE)
                    .message(DUPLICATE_ERROR)
                    .build();
        }
        return ResponseDto.<Void>builder()
                .success(true)
                .message(OK)
                .build();
    }
}
