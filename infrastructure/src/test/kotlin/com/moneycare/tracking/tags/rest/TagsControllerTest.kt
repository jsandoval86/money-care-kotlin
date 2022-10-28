package com.moneycare.tracking.tags.rest

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.moneycare.tracking.tags.Tag
import com.moneycare.tracking.tags.TagRepository
import com.moneycare.tracking.tags.TagType
import com.moneycare.tracking.tags.rest.response.TagResponse
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.groups.Tuple
import org.hamcrest.Matchers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TagsControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Autowired
    private lateinit var tagRepository: TagRepository

    @Test
    fun getTags() {
        val tag1 = Tag.undefined()
        val tag2 = Tag.create("salary", TagType.income)
        tagRepository.save(tag1)
        tagRepository.save(tag2)

        val response = mockMvc.perform(
            MockMvcRequestBuilders.get(URLTags.URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.length()", Matchers.equalTo(2)))

        val tagPage : List<TagResponse> = objectMapper.readValue(response.andReturn().response.contentAsString)

        assertEquals(2, tagPage.size)
        assertThat(tagPage)
            .extracting(TagResponse::id)
            .containsExactlyInAnyOrder(
                Tuple.tuple(tag1.id),
                Tuple.tuple(tag2.id)
            )
    }
}