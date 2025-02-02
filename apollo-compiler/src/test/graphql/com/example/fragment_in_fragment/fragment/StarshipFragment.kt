// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_in_fragment.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ResponseFieldMarshaller
import com.apollographql.apollo.api.ResponseReader
import com.example.fragment_in_fragment.type.CustomType
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "LocalVariableName", "RemoveExplicitTypeArguments",
    "NestedLambdaShadowedImplicitParameter")
data class StarshipFragment(
  val __typename: String,
  /**
   * The ID of an object
   */
  val id: String,
  /**
   * The name of this starship. The common name, such as "Death Star".
   */
  val name: String?,
  val pilotConnection: PilotConnection?
) : GraphqlFragment {
  override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
    it.writeString(RESPONSE_FIELDS[0], __typename)
    it.writeCustom(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField, id)
    it.writeString(RESPONSE_FIELDS[2], name)
    it.writeObject(RESPONSE_FIELDS[3], pilotConnection?.marshaller())
  }

  companion object {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forCustomType("id", "id", null, false, CustomType.ID, null),
        ResponseField.forString("name", "name", null, true, null),
        ResponseField.forObject("pilotConnection", "pilotConnection", null, true, null)
        )

    val FRAGMENT_DEFINITION: String = """
        |fragment starshipFragment on Starship {
        |  __typename
        |  id
        |  name
        |  pilotConnection {
        |    __typename
        |    edges {
        |      __typename
        |      node {
        |        __typename
        |        ...pilotFragment
        |      }
        |    }
        |  }
        |}
        """.trimMargin()

    val POSSIBLE_TYPES: Array<String> = arrayOf("Starship")

    operator fun invoke(reader: ResponseReader): StarshipFragment {
      val __typename = reader.readString(RESPONSE_FIELDS[0])
      val id = reader.readCustomType<String>(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField)
      val name = reader.readString(RESPONSE_FIELDS[2])
      val pilotConnection = reader.readObject<PilotConnection>(RESPONSE_FIELDS[3]) { reader ->
        PilotConnection(reader)
      }

      return StarshipFragment(
        __typename = __typename,
        id = id,
        name = name,
        pilotConnection = pilotConnection
      )
    }
  }

  data class Node(
    val __typename: String,
    val fragments: Fragments
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
      it.writeString(RESPONSE_FIELDS[0], __typename)
      fragments.marshaller().marshal(it)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("__typename", "__typename", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): Node {
        val __typename = reader.readString(RESPONSE_FIELDS[0])
        val fragments = reader.readConditional(RESPONSE_FIELDS[1]) { conditionalType, reader ->
          val pilotFragment = if (PilotFragment.POSSIBLE_TYPES.contains(conditionalType))
              PilotFragment(reader) else null
          Fragments(
            pilotFragment = pilotFragment!!
          )
        }

        return Node(
          __typename = __typename,
          fragments = fragments
        )
      }
    }

    data class Fragments(
      val pilotFragment: PilotFragment
    ) {
      fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
        pilotFragment.marshaller().marshal(it)
      }
    }
  }

  data class Edge(
    val __typename: String,
    /**
     * The item at the end of the edge
     */
    val node: Node?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
      it.writeString(RESPONSE_FIELDS[0], __typename)
      it.writeObject(RESPONSE_FIELDS[1], node?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forObject("node", "node", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): Edge {
        val __typename = reader.readString(RESPONSE_FIELDS[0])
        val node = reader.readObject<Node>(RESPONSE_FIELDS[1]) { reader ->
          Node(reader)
        }

        return Edge(
          __typename = __typename,
          node = node
        )
      }
    }
  }

  data class PilotConnection(
    val __typename: String,
    /**
     * A list of edges.
     */
    val edges: List<Edge?>?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller {
      it.writeString(RESPONSE_FIELDS[0], __typename)
      it.writeList(RESPONSE_FIELDS[1], edges) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeObject(value?.marshaller())
        }
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forList("edges", "edges", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): PilotConnection {
        val __typename = reader.readString(RESPONSE_FIELDS[0])
        val edges = reader.readList<Edge>(RESPONSE_FIELDS[1]) {
          it.readObject<Edge> { reader ->
            Edge(reader)
          }

        }
        return PilotConnection(
          __typename = __typename,
          edges = edges
        )
      }
    }
  }
}
